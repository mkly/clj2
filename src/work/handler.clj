(ns work.handler
  (:require [ataraxy.response :as response] 
            [hiccup.core :refer [html]]
            [integrant.core :as ig]))

(defmethod ig/init-key :work.handler/hello [_ _options]
  (fn [{[_ name] :ataraxy/result}]
    [::response/ok (html
                     [:head
                      [:title (str "Hello " name)]
                      [:body
                       [:h1 {:style "text-align: center"} (str "Hello " name)]]])]))

(defmethod ig/init-key :work.handler/another [_ _options]
  (fn [{[_ name] :ataraxy/result}]
    [::response/ok (html
                     [:head
                      [:title (str "Another" name)]
                      [:body
                       [:h1 {:style "text-align: center"} (str "Another")]]])]))
