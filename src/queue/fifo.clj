(ns queue.fifo)

(defn new-queue []
  {:content nil})

(defn size [queue]
  (if (some? (get queue :content))
    1
    0))

(defn push [queue element]
  (assoc queue :content element))

