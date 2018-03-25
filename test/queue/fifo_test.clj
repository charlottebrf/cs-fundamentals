(ns queue.fifo_test
  (:require [clojure.test :refer :all]
            [queue.fifo :refer :all]))


;Create a queue with a First-In-First-Out (FIFO) data structure.

;empty
;given an element it will return a list containing that element
(deftest queues
  (testing "a new queue has size zero"
    (let [queue (new-queue)]
      (is (= (size queue) 0))))

  (testing "pushing into an existing queue increases its size by one"
    (let [queue (new-queue)
          added-queue (push queue "First")]
      (is (= (size added-queue) 1))))

  (testing "pushing two elements into an existing queue with one element increases its size by one"
    (let [queue (new-queue)
          queue2 (push queue "First")
          queue3 (push queue2 "Second")]
      (prn "HERE IS ADDED QUEUE 2" queue3)
      (is (= (size queue3) 2)))))

