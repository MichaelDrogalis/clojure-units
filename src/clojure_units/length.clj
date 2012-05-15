(ns clojure_units.length)

(def *miles-meters-ratio* 1.609)
(def *metric-ratio* 1000)

(defrecord Miles [length])
(defrecord Kilometers [length])
(defrecord Meters [length])

(defprotocol Convertable
  (to-miles [this])
  (to-km [this])
  (to-meters [this]))

(extend-type Miles
  Convertable
  (to-miles [this] (Miles. (:length this)))
  (to-km [this] (Kilometers. (* (:length this) *miles-meters-ratio*)))
  (to-meters [this] (to-meters (to-km this))))

(extend-type Kilometers
  Convertable
  (to-miles [this] (Miles. (/ (:length this) *miles-meters-ratio*)))
  (to-km [this] (Kilometers. (:length this)))
  (to-meters [this] (Meters. (* (:length this) *metric-ratio*))))

(extend-type Meters
  Convertable
  (to-miles [this] (to-miles (to-km this)))
  (to-km [this] (Kilometers. (/ (:length this) *metric-ratio*)))
  (to-meters [this] this))