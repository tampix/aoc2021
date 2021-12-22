(ns aoc.d2
  (:require [aoc.util :as util]
            [clojure.string :as str]))

(defn move
  [position [action n]]
  (let [[k f] ({:forward [:horizontal +]
                :down    [:depth +]
                :up      [:depth -]} action)]
    (update position k f n)))

(defn move2
  [position [action n]]
  (if-let [[k f] ({:down [:aim +]
                   :up   [:aim -]} action)]
    (update position k f n)
    (-> position
        (update :horizontal + n)
        (update :depth + (* (:aim position) n)))))

(defn solve
  [{:keys [horizontal depth]}]
  (* horizontal depth))

(defn day2
  []
  (let [input (->> (str/split (util/read-input 2)
                              #"\s+")
                   (partition 2)
                   (map (juxt (comp keyword first)
                              (comp util/parse-long second))))
        [part1 part2] (->> input
                           (util/juxt-reduce [move move2]
                                             (repeat {:horizontal 0 :depth 0 :aim 0}))
                           (map solve))]
    ;; part1
    (println part1)
    ;; part2
    (println part2)))
