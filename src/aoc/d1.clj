(ns aoc.d1
  (:require [clojure.string :as str]
            [aoc.util :as util]))

(defn filter-increasing-pairs
  [coll]
  (->> coll
       (partition 2 1)
       (filter (partial apply <))))

(defn map-sum-triplets
  [coll]
  (->> coll
       (partition 3 1)
       (map (partial apply +))))

(defn day1
  []
  (let [input (util/read-input-ints 1)]
    ;; part1
    (->> input
         filter-increasing-pairs
         count
         println)
    ;; part2
    (->> input
         map-sum-triplets
         filter-increasing-pairs
         count
         println)))
