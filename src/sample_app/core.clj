(ns sample-app.core
  (:gen-class)
  (:require [reitit.ring :as ring]
            [ring.adapter.jetty :as jetty]))

;; https://github.com/metosin/reitit/blob/master/examples/ring-example/src/example/server.clj
(def app
  "ring router app"
  (ring/ring-handler
   (ring/router
    ["/" {:get (fn [_]
                 {:status 200, :body "http server running!"})}]
    ["/ping" {:get (fn [_]
                     {:status 200, :body "pong!"})}])
   (ring/create-default-handler)))

(defn -main
  "software entry point"
  [& _]
  (jetty/run-jetty #'app {:port 3000, :join? false})
  (println "server running in port 3000"))
