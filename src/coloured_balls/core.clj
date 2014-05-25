(ns coloured-balls.core
  (:use [rosado.processing]
        [rosado.processing.applet]))

;; here's a function which will be called by Processing's (PApplet)
;; draw method every frame. Place your code here. If you eval it
;; interactively, you can redefine it while the applet is running and
;; see effects immediately

;;; set values for the board drawn by java applet
(def board-width 400)
(def board-height 400)


(defn draw-ball [ball]
        (fill (:red ball) (:green ball) (:blue ball))
        (ellipse (:x ball) (:y ball) (:radius ball) (:radius ball)))

(defn make-ball []
  "Make a new ball of random position, size and colour"
        {:x (rand-int board-width) :y (rand-int board-height) :red (rand-int 256) :blue (rand-int 256) :green (rand-int 256) :radius (+ 1 (rand-int 70))})

(defn draw
  "Example usage of with-translation and with-rotation."
  []
        (draw-ball (make-ball))
  )

(defn setup []
  "Runs once."
  (smooth)
  (no-stroke)
  (fill 226)
  (framerate 10))

;; Now we just need to define an applet:

(defapplet balls :title "Coloured balls"
  :setup setup :draw draw :size [board-width board-height])

 (run balls)
