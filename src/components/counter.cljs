(ns components.counter
  (:require [reagent.core :as reagent]
            [dictionary :as dict]))

(defn component
  "This counter can be increased or decreased by clicking on the `+` and `-` buttons."
  ([]
   [component 123])
  ([init-count]
   (reagent/with-let [count (reagent/atom init-count)]
     [:div
      [:h1 [dict/translate :my-count] " " @count]
      [:span [dict/translate :counter-description]]
      [:div
       [:button {:on-click #(swap! count inc)}
        "+"]
       [:button {:on-click #(swap! count dec)}
        "-"]]])))
