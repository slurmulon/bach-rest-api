(ns warble-rest-api.core
    (:require [warble.lexer :refer [parse]]
              [warble.track :refer [compile-track]]
              [liberator.core :refer [resource defresource]]
              [ring.middleware.params :refer [wrap-params]]
              ; [clojure.java.io :as io]
              [compojure.core :refer [defroutes ANY]]))

(defroutes app
  (ANY "/" [] (resource))
  (ANY "/track" []
    (resource
      :allowed-methods [:post]
      :available-media-types ["application/json" "text/plain"]
      :handle-created (fn [ctx]
                        (let [body (slurp (get-in ctx [:request :body]))]
                          (compile-track (parse body)))))))
(def handler
  (-> app
      wrap-params))
