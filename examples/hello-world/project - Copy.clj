(defproject hello-world "0.23.1"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [uncomplicate/neanderthal "0.23.1"]]
  :exclusions [[org.jcuda/jcuda-natives :classifier "apple-x86_64"]
               [org.jcuda/jcublas-natives :classifier "apple-x86_64"]]
  :jvm-opts ^:replace ["-Dclojure.compiler.direct-linking=true" 
                       #_"--add-opens=java.base/jdk.internal.ref=ALL-UNNAMED"]
  :plugins [[lein-with-env-vars "0.1.0"]]
  :env-vars {:DYLD_LIBRARY_PATH "C:\\Program Files (x86)\\IntelSWTools\\compilers_and_libraries_2019\\windows\\redist\\intel64_win\\tbb\\vc_mt;C:\\Program Files (x86)\\IntelSWTools\\compilers_and_libraries_2019\\windows\\redist\\intel64_win\\mkl;C:\\Program Files (x86)\\IntelSWTools\\compilers_and_libraries_2019\\windows\\redist\\intel64_win\\compiler;C:\\Program Files (x86)\\IntelSWTools\\compilers_and_libraries_2019\\windows\\redist\\intel64_win\\tbb\\vc_mt;C:\\Program Files (x86)\\IntelSWTools\\compilers_and_libraries_2019\\windows\\redist\\intel64_win\\mkl;C:\\Program Files (x86)\\IntelSWTools\\compilers_and_libraries_2019\\windows\\redist\\intel64_win\\compiler;C:\\Program Files (x86)\\IntelSWTools\\compilers_and_libraries_2019\\windows\\redist\\intel64_win\\tbb\\vc_mt;C:\\Program Files (x86)\\IntelSWTools\\compilers_and_libraries_2019\\windows\\redist\\intel64_win\\mkl;C:\\Program Files (x86)\\IntelSWTools\\compilers_and_libraries_2019\\windows\\redist\\intel64_win\\compiler;C:\\Program Files (x86)\\IntelSWTools\\compilers_and_libraries_2019\\windows\\redist\\intel64_win\\tbb\\vc_mt;C:\\Program Files (x86)\\IntelSWTools\\compilers_and_libraries_2019\\windows\\redist\\intel64_win\\mkl;C:\\Program Files (x86)\\IntelSWTools\\compilers_and_libraries_2019\\windows\\redist\\intel64_win\\compiler;C:\\Program Files (x86)\\IntelSWTools\\compilers_and_libraries_2019\\windows\\redist\\intel64_win\\tbb\\vc_mt;C:\\Program Files (x86)\\IntelSWTools\\compilers_and_libraries_2019\\windows\\redist\\intel64_win\\mkl;C:\\Program Files (x86)\\IntelSWTools\\compilers_and_libraries_2019\\windows\\redist\\intel64_win\\compiler"}		

)

; https://github.com/uncomplicate/neanderthal/issues/57
; already did https://github.com/uncomplicate/neanderthal/issues/55


; $ lein with-env-vars repl ; does not work

; open jdk issue ?? https://stackoverflow.com/questions/52511778/how-to-install-openjdk-11-on-windows

; but java --version and where java seems ok ; anyway setup the JAVA_HOME as well on top of PATH

; (System/getenv "LD_LIBRARY_PATH")

;  :plugins [[lein-with-env-vars "0.1.0"]]
;  :env-vars {:DYLD_LIBRARY_PATH "C:\\Users\\ngchichun\\mkl_redist"}		

; (System/getenv "PATH")

; "C:\\Program Files (x86)\\IntelSWTools\\compilers_and_libraries_2019\\windows\\redist\\intel64_win\\tbb\\vc_mt;C:\\Program Files (x86)\\IntelSWTools\\compilers_and_libraries_2019\\windows\\redist\\intel64_win\\mkl;C:\\Program Files (x86)\\IntelSWTools\\compilers_and_libraries_2019\\windows\\redist\\intel64_win\\compiler;C:\\Program Files (x86)\\IntelSWTools\\compilers_and_libraries_2019\\windows\\redist\\intel64_win\\tbb\\vc_mt;C:\\Program Files (x86)\\IntelSWTools\\compilers_and_libraries_2019\\windows\\redist\\intel64_win\\mkl;C:\\Program Files (x86)\\IntelSWTools\\compilers_and_libraries_2019\\windows\\redist\\intel64_win\\compiler;C:\\Program Files (x86)\\IntelSWTools\\compilers_and_libraries_2019\\windows\\redist\\intel64_win\\tbb\\vc_mt;C:\\Program Files (x86)\\IntelSWTools\\compilers_and_libraries_2019\\windows\\redist\\intel64_win\\mkl;C:\\Program Files (x86)\\IntelSWTools\\compilers_and_libraries_2019\\windows\\redist\\intel64_win\\compiler;C:\\Program Files (x86)\\IntelSWTools\\compilers_and_libraries_2019\\windows\\redist\\intel64_win\\tbb\\vc_mt;C:\\Program Files (x86)\\IntelSWTools\\compilers_and_libraries_2019\\windows\\redist\\intel64_win\\mkl;C:\\Program Files (x86)\\IntelSWTools\\compilers_and_libraries_2019\\windows\\redist\\intel64_win\\compiler;C:\\Program Files (x86)\\IntelSWTools\\compilers_and_libraries_2019\\windows\\redist\\intel64_win\\tbb\\vc_mt;C:\\Program Files (x86)\\IntelSWTools\\compilers_and_libraries_2019\\windows\\redist\\intel64_win\\mkl;C:\\Program Files (x86)\\IntelSWTools\\compilers_and_libraries_2019\\windows\\redist\\intel64_win\\compiler;C:\\Program Files\\NVIDIA GPU Computing Toolkit\\CUDA\\v10.0\\bin;C:\\Program Files\\NVIDIA GPU Computing Toolkit\\CUDA\\v10.0\\libnvvp;C:\\Windows\\system32;C:\\Windows;C:\\Windows\\System32\\Wbem;C:\\Windows\\System32\\WindowsPowerShell\\v1.0\\;C:\\Program Files\\NVIDIA Corporation\\NVIDIA NvDLISR;C:\\Users\\ngchichun\\Downloads\\openjdk-12.0.1_windows-x64_bin\\jdk-12.0.1\\bin;C:\\Program Files\\nodejs\\;C:\\WINDOWS\\system32;C:\\WINDOWS;C:\\WINDOWS\\System32\\Wbem;C:\\WINDOWS\\System32\\WindowsPowerShell\\v1.0\\;C:\\WINDOWS\\System32\\OpenSSH\\;C:\\Users\\ngchichun\\AppData\\Local\\Temp\\;C:\\Program Files (x86)\\NVIDIA Corporation\\PhysX\\Common;C:\\Users\\ngchichun\\AppData\\Local\\Microsoft\\WindowsApps;C:\\Users\\ngchichun\\AppData\\Local\\GitHubDesktop\\bin;C:\\Users\\ngchichun\\AppData\\Roaming\\npm;C:\\Users\\ngchichun\\AppData\\Local\\Programs\\Microsoft VS Code\\bin;C:\\Users\\ngchichun\\AppData\\Local\\Microsoft\\WindowsApps;"

; PATH=
;C:\Program Files (x86)\IntelSWTools\compilers_and_libraries_2019\windows\redist\intel64_win\tbb\vc_mt
;C:\Program Files (x86)\IntelSWTools\compilers_and_libraries_2019\windows\redist\intel64_win\mkl
;C:\Program Files (x86)\IntelSWTools\compilers_and_libraries_2019\windows\redist\intel64_win\compiler
;C:\Program Files (x86)\IntelSWTools\compilers_and_libraries_2019\windows\redist\intel64_win\tbb\vc_mt
;C:\Program Files (x86)\IntelSWTools\compilers_and_libraries_2019\windows\redist\intel64_win\mkl
;C:\Program Files (x86)\IntelSWTools\compilers_and_libraries_2019\windows\redist\intel64_win\compiler
;C:\Program Files (x86)\IntelSWTools\compilers_and_libraries_2019\windows\redist\intel64_win\tbb\vc_mt
;C:\Program Files (x86)\IntelSWTools\compilers_and_libraries_2019\windows\redist\intel64_win\mkl
;C:\Program Files (x86)\IntelSWTools\compilers_and_libraries_2019\windows\redist\intel64_win\compiler
;C:\Program Files (x86)\IntelSWTools\compilers_and_libraries_2019\windows\redist\intel64_win\tbb\vc_mt
;C:\Program Files (x86)\IntelSWTools\compilers_and_libraries_2019\windows\redist\intel64_win\mkl
;C:\Program Files (x86)\IntelSWTools\compilers_and_libraries_2019\windows\redist\intel64_win\compiler
;C:\Program Files (x86)\IntelSWTools\compilers_and_libraries_2019\windows\redist\intel64_win\tbb\vc_mt
;C:\Program Files (x86)\IntelSWTools\compilers_and_libraries_2019\windows\redist\intel64_win\mkl
;C:\Program Files (x86)\IntelSWTools\compilers_and_libraries_2019\windows\redist\intel64_win\compiler

;C:\Program Files\NVIDIA GPU Computing Toolkit\CUDA\v10.0\bin;C:\Program Files\NVIDIA GPU Computing Toolkit\CUDA\v10.0\libnvvp;C:\Windows\system32
;C:\Windows
;C:\Windows\System32\Wbem
;C:\Windows\System32\WindowsPowerShell\v1.0\
;C:\Program Files\NVIDIA Corporation\NVIDIA NvDLISR
;C:\Users\ngchichun\Downloads\openjdk-12.0.1_windows-x64_bin\jdk-12.0.1\bin
;C:\Program Files\nodejs\
;C:\WINDOWS\system32;C:\WINDOWS
;C:\WINDOWS\System32\Wbem
;C:\WINDOWS\System32\WindowsPowerShell\v1.0\
;C:\WINDOWS\System32\OpenSSH\
;C:\Users\ngchichun\AppData\Local\Temp\
;C:\Program Files (x86)\NVIDIA Corporation\PhysX\Common
;C:\Users\ngchichun\AppData\Local\Microsoft\WindowsApps
;C:\Users\ngchichun\AppData\Local\GitHubDesktop\bin
;C:\Users\ngchichun\AppData\Roaming\npm
;C:\Users\ngchichun\AppData\Local\Programs\Microsoft VS Code\bin
;C:\Users\ngchichun\AppData\Local\Microsoft\WindowsApps;
