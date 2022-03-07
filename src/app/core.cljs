(ns app.core
  (:require
   [app.helper :as h]
   [reagent.dom :as d]
   [malli.dev.cljs :as dev]
   [malli.dev.pretty :as pretty]))


(defn home-page []
  (h/my-helper [1.2])
  (fn []
    [:div "test"]))


;; -------------------------
;; Initialize app

(defn mount-root []
  (d/render [home-page] (.getElementById js/document "app")))

(defn ^:dev/after-load refresh []
  (prn "Hot code Remount")
  ; Check all malli function "specs"
  (dev/start! {:report (pretty/reporter)})
  (mount-root))

(defn ^:export init! []
  (mount-root))
