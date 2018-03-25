(ns queue.fifo)

(defn nested-queue [element]
  {:content element :next nil})

(defn new-queue []
  (nested-queue nil))

(defn size [queue]
  (if (some? (get queue :content))
    (+ 1 (size (queue :next)))
    0))


(defn push [queue element]
  (if (nil? (get queue :content))
    (assoc queue :content element)
    (assoc queue :next (nested-queue element))
    ))

