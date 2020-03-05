(ns project-euler.01problem)

(reduce + (filter (fn [x] (or (= 0 (mod x 5))
                              (= 0 (mod x 3))))
                  (range 1000)))
