(ns bach-rest-api.handler
  (:require [bach.ast :as ast]
            [bach.track :refer [compile-track]]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.util.json-response :refer [json-response]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defroutes app-routes
  (GET "/" [] (json-response {:message "bach REST API"}))
  (POST "/track" {body :body} (json-response (-> body slurp ast/parse compile-track)))
  (route/not-found (json-response {:error "Not Found"})))

(def app
  (wrap-defaults app-routes (assoc-in site-defaults [:security :anti-forgery] false)))
