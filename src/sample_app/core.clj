(ns sample-app.core
  (:gen-class)
  (:require [reitit.ring :as ring]
            [ring.adapter.jetty :as jetty]))

(def routers
  "ring router app"
  (ring/router
   ["/" {:get (fn [_]
                {:status 200, :body "http server running!"})}]
   ["/ping" {:get (fn [_]
                    {:status 200, :body "pong!"})}]))

(defn -main
  "software entry point"
  [& _]
  (jetty/run-jetty #'routers {:port 3000, :join? false})
  (println "server running in port 3000"))
