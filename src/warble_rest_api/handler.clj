(ns warble-rest-api.handler
  (:require [warble.lexer :refer [parse]]
            [warble.track :refer [compile-track]]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.util.json-response :refer [json-response]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defroutes app-routes
  (GET "/" [] (json-response {:message "Warble REST API"}))
  (POST "/track" {body :body} (json-response (-> body slurp parse compile-track)))
  (route/not-found (json-response {:error "Not Found"})))

(def app
  (wrap-defaults app-routes (assoc-in site-defaults [:security :anti-forgery] false)))
