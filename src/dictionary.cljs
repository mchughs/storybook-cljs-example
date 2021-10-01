(ns dictionary
  (:require [tongue.core :as tongue]
            [reagent.core :as reagent]
            ))

(def locale (reagent/atom :en))

(def dicts
  {:en {:my-count "My Count:"
        :counter-description "This counter component keeps local state about the number of times the button has been clicked."}
   :fr {:my-count "Mon compte:"
        :counter-description "Ce composant de compteur conserve l'état local sur le nombre de fois que le bouton a été cliqué."}
   :es {:my-count "Mi recuento:"
        :counter-description "Este componente de contador mantiene el estado local sobre el número de veces que se ha hecho clic en el botón."}
   :zh {:my-count "我的伯爵："
        :counter-description "这个计数器组件保持关于按钮被点击次数的本地状态."}
   :kr {:my-count "마이 카운트:"
        :counter-description "이 카운터 구성요소는 버튼을 클릭한 횟수에 대한 로컬 상태를 유지합니다."}})

(defn translate [k]  
  [:<> ((tongue/build-translate dicts) @locale k)])
