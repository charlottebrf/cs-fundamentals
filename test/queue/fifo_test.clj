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
          queue1 (push queue "First")
          queue2 (push queue1 "Second")]
      (is (= (size queue2) 2))))

  (testing "pushing three elements into an existing queue with two elements increases size by one"
    (let [queue (new-queue)
          queue1 (push queue "First")
          queue2 (push queue1 "Second")
          queue3 (push queue2 "Three")]
      (is (= (size queue3) 3))))

  (testing "popping out an existing queue returns a tuple of the new queue and popped element"
    (let [queue (new-queue)
          added-queue (push queue "First")
          result (special-pop added-queue)]
      (is (= result [nil "First"]))))

  (testing "popping out of an existing queue decreases its size by one"
    (let [queue (new-queue)
          added-queue (push queue "First")
          removed-queue (special-pop added-queue)]
      (is (= (size removed-queue) 0))))

  (testing "popping an existing queue of two elements returns a tuple of the new queue and popped element"
    (let [queue (new-queue)
          first-queue (push queue "First")
          second-queue (push first-queue "Second")
          result (special-pop second-queue)]
      (is (= result [{:content "Second"} "First"]))))

  (testing "popping out one element from an existing queue with two elements decreases its size by one"
    (let [queue (new-queue)
          first-queue (push queue "First")
          second-queue (push first-queue "Second")
          removed-queue-1 (special-pop second-queue)]
      (is (= (size (first removed-queue-1)) 1)))))


