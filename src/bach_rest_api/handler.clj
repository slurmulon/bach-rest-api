(ns bach-rest-api.handler
  (:require [bach.ast :as ast]
            [bach.track :refer [compile-track]]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.util.json-response :refer [json-response]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [clojure.tools.logging :as log]))

(defroutes app-routes
  (GET "/" [] (json-response {:message "Bach REST API"}))
  (POST "/track" {body :body}
        (try
          (let [track (-> body slurp ast/parse compile-track)]
            (json-response track))
          (catch Exception e
            (log/error e "Track compilation error")
            (merge (json-response {:error (:via e)}) {:status 400}))))
  (route/not-found (json-response {:error "Not Found"})))

(def app
  (wrap-defaults app-routes (assoc-in site-defaults [:security :anti-forgery] false)))
