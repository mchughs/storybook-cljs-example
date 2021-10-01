(ns storybook.utils
  (:require [reagent.core :as reagent]
            [dictionary :as dict]
            ["@storybook/addon-docs" :refer (Title
                                             Subtitle
                                             Description
                                             Primary
                                             ArgsTable
                                             Stories
                                             PRIMARY_STORY)]))

(defn ->opts [^js args]
  (js->clj args :keywordize-keys true))

(defn ->default [opts]
  (-> opts
      (update :component (comp reagent/reactify-component deref))
      (assoc :parameters {:docs {:page (fn []
                                         (let [docstring (-> opts :component meta :doc)]
                                           (reagent/as-element
                                            [:<>
                                             [:> Title]
                                             [:> Subtitle]
                                             [:> Description docstring]
                                             [:> Primary]
                                             [:> ArgsTable {:story PRIMARY_STORY}]
                                             [:> Stories]])))}})
      clj->js))

(defn locale-state-wrapper
  [context & children]  
  (let [_ (reset! dict/locale (-> context ->opts (get-in [:globals :locale]) keyword))]
    (into [:<>] children)))
