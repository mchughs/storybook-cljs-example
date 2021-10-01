(ns storybook.stories.counter-stories
  (:require [components.counter :as counter]
            [storybook.utils :as utils]
            [reagent.core :as reagent]))

(def ^:export default
  (utils/->default
   {:title "Counter Component"
    :component #'counter/component
    :args {:init-count 99}
    :argTypes {:init-count {:description "The count at which the counter starts."}}}))

(defn ^:export default-counter [_args context]
  (reagent/as-element
   [utils/locale-state-wrapper context
    [counter/component]]))

(defn ^:export with-init-counter [args context]
  (reagent/as-element
   [utils/locale-state-wrapper context
    [counter/component (:init-count (utils/->opts args))]]))
