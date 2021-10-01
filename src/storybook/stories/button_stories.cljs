(ns storybook.stories.button-stories
  (:require [components.button :as button]
            [storybook.utils :as utils]
            [reagent.core :as reagent]))

(def ^:export default
  (utils/->default
   {:title "My basic button"
    :component #'button/component
    :argTypes {:on-click {:action "clicked"}}}))

(defn ^:export foo-button [args context]
  (reagent/as-element
   [button/component (utils/->opts args) "foo"]))

(defn ^:export bar-button [args context]
  (reagent/as-element
   [button/component (utils/->opts args) "bar"]))
