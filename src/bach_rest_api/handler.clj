(ns bach-rest-api.handler
  (:require [bach.track :refer [compose]]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.util.json-response :refer [json-response]]
            [ring.middleware.json :only [wrap-json-body]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [clojure.tools.logging :as log]))

(defroutes app-routes
  (GET "/" [] (json-response {:message "Bach REST API"}))
  (POST "/track" {body :body}
        (let [source (slurp body)]
          (try
            (let [track (compose source)]
              (log/info "[bach-rest-api/track] Valid track compiled. Source Bach data:")
              (log/info (prn source))
              (json-response track))
            (catch Exception e
              (log/error e "[bach-rest-api/track] Invalid track, compilation FAILED. Source Bach data:")
              (log/error (prn source))
              (merge (json-response {:error (:via e)}) {:status 400})))))
  (route/not-found (json-response {:error "Not Found"})))

(def app
  (wrap-defaults app-routes (assoc-in site-defaults [:security :anti-forgery] false)))
