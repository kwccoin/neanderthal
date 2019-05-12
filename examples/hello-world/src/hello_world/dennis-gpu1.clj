;; https://dragan.rocks/articles/18/CUDA-10-in-Clojure

;; cd C:\Users\ngchichun\Documents\Github\neanderthal-err
;; lein repl


(require '[uncomplicate.clojurecuda.core :refer :all]
         '[uncomplicate.commons.core :refer :all])

(println (. System getProperty "java.library.path"))

(init)
   (device-count)

(def my-nvidia-gpu (device 0))
   (info my-nvidia-gpu)

(def ctx (context my-nvidia-gpu))
   (info ctx)
 
 '(:dev-runtime-pending-launch-count 2048  :dev-runtime-sync-depth 2  :malloc-heap-size 8388608  :stack-size 1024  :api-version 3020  :stream-priority-range (0 -1)  :cache-config :prefer-none  :printf-fifo-size 1048576  :device #object(jcuda.driver.CUdevice 0x1db4190c "CUdevice[nativePointer=0x0]")  :shared-config :four-byte-bank-size)
 
(= ctx (current-context))

(def gpu-array (mem-alloc 1024))

(def main-array (float-array (range 256)))

(take 10 main-array)

(memcpy-host! main-array gpu-array)

(def kernel-source
      "extern \"C\"
         __global__ void increment (int n, float *a) {
           int i = blockIdx.x * blockDim.x + threadIdx.x;
           if (i < n) {
             a[i] = a[i] + 1.0f;
        }
       };")
	   
(def hello-program (compile! (program kernel-source))) ;; do not work
(def hello-module (module hello-program))
(def increment (function hello-module "increment"))

(launch! increment (grid-1d 256) (parameters 256 gpu-array))

(take 12 (memcpy-host! gpu-array (float-array 256)))

;; above not working ... not sure how to proceed

;; use 10.0 all works ok

;; try my next stage anyway using Intel MKL

;; trying mkl intel seems is here: C:\Program Files (x86)\IntelSWTools\compilers_and_libraries_2019.3.203\windows\redist\intel64_win\mkl

;; https://neanderthal.uncomplicate.org/articles/getting_started.html

;; https://clojurecuda.uncomplicate.org/articles/getting_started.html



;: https://dragan.rocks/articles/19/Deep-Learning-in-Clojure-From-Scratch-to-GPU-1-Representing-Layers-and-Connections

;; When the installation of Intel MKL for Windows* is complete, set the PATH, LIB, and INCLUDE environment variables in the command shell using the mklvars.bat script in the bin subdirectory of the Intel MKL installation directory.

;; cd C:\Program Files (x86)\IntelSWTools\compilers_and_libraries_2019\windows\mkl\bin>

;; REM cannot use the main one as it cannot detect vs2017 even if installed
;; mklvars intel64 

;; check it can find dll
;; where mkl_intel_thread.dll

(require '[uncomplicate.commons.core :refer [with-release]]
         '[uncomplicate.neanderthal
           [native :refer [dv dge]]
           [core :refer [mv!]]]) ;;mtl can be found but needed to use mtlvars.bat in its bin

(with-release [x (dv 0.3 0.9)
               w1 (dge 4 2 [0.3 0.6
                            0.1 2.0
                            0.9 3.7
                            0.0 1.0]
                       {:layout :row})
               h1 (dv 4)]
  (println  w1 x h1))


(with-release [x (dv 0.3 0.9)
               w1 (dge 4 2 [0.3 0.6
                            0.1 2.0
                            0.9 3.7
                            0.0 1.0]
                       {:layout :row})
               h1 (dv 4)]
  (println (mv! w1 x h1)))
  
#RealBlockVector[double, n:4, offset: 0, stride:1]
[   0.00    1.83    3.60    0.90 ]

(require '[uncomplicate.commons.core :refer [with-release let-release Releaseable release]]
         '[uncomplicate.clojurecuda.core :as cuda :refer [current-context default-stream synchronize!]]
         '[uncomplicate.clojurecl.core :as opencl :refer [*context* *command-queue* finish!]]
         '[uncomplicate.neanderthal
           [core :refer [mv! axpy! scal! transfer! transfer mm! rk! view-ge vctr ge entry!]]
           [native :refer [native-double native-float dv dge]]
           [vect-math :refer [tanh! linear-frac!]]
           [cuda :refer [cuda-float]]
           [opencl :refer [opencl-float]]])
(import 'clojure.lang.IFn)		   

		   