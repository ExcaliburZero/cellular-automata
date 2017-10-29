# Cellular Automata
This is a script for displaying various cellular automata in the terminal screen.

## Examples
### Elementary Cellular Automata
A 1D elementary cellular automata can be run by using the `elementary` subcommand. The following parameters can be specified using command line flags:

* rule - The rule to use for determing the cell values for new generations. (default `110`)
* range - The range of cells from the current cell to look at for the rewrite rule. (default `1`)
* size - The length of the output lines. (default `80`)
* interval - The time interval, in miliseconds, between line prints. (default `75`)
* empty - The character to print for empty cells. (default ` `)
* filled - The character to print for filled cells. (default `█`)
* generation - Accepts an initial generation from standard input. Spaces are converted into empty cells, and non-spaces are converted in filled cells.

```
$ sbt "run elementary --rule 18"
                                        █                                       
                                       █ █                                      
                                      █   █                                     
                                     █ █ █ █                                    
                                    █       █                                   
                                   █ █     █ █                                  
                                  █   █   █   █                                 
                                 █ █ █ █ █ █ █ █                                
                                █               █                               
                               █ █             █ █                              
                              █   █           █   █                             
                             █ █ █ █         █ █ █ █                            
                            █       █       █       █                           
                           █ █     █ █     █ █     █ █                          
                          █   █   █   █   █   █   █   █                         
                         █ █ █ █ █ █ █ █ █ █ █ █ █ █ █ █                        
                        █                               █                       
                       █ █                             █ █                      
                      █   █                           █   █                     
                     █ █ █ █                         █ █ █ █                    
                    █       █                       █       █                   
                   █ █     █ █                     █ █     █ █                  
                  █   █   █   █                   █   █   █   █                 
                 █ █ █ █ █ █ █ █                 █ █ █ █ █ █ █ █                
                █               █               █               █               
```

```
$ sbt "run elementary --rule 9768792 --range 4 --size 120"
                                                            █                                                           
                                                          ███                                                           
                                                       █    █                                                           
                                                     ███  ███                                                           
                                                  █         █                                                           
                                                ███       ███                                                           
                                             █    █    █    █                                                           
                                           ███  ███  ███  ███                                                           
                                        █                   █                                                           
                                      ███                 ███                                                           
                                   █    █              █    █                                                           
                                 ███  ███            ███  ███                                                           
                              █         █         █         █                                                           
                            ███       ███       ███       ███                                                           
                         █    █    █    █    █    █    █    █                                                           
                       ███  ███  ███  ███  ███  ███  ███  ███                                                           
                    █                                       █                                                           
                  ███                                     ███                                                           
               █    █                                  █    █                                                           
             ███  ███                                ███  ███                                                           
          █         █                             █         █                                                           
        ███       ███                           ███       ███                                                           
     █    █    █    █                        █    █    █    █                                                           
   ███  ███  ███  ███                      ███  ███  ███  ███                                                           
```

```
$ sbt "run elementary --rule 18 --generation"
Enter the initial generation:
          1                        t           s
          █                        █           █                                
         █ █                      █ █         █ █                               
        █   █                    █   █       █   █                              
       █ █ █ █                  █ █ █ █     █ █ █ █                             
      █       █                █       █   █       █                            
     █ █     █ █              █ █     █ █ █ █     █ █                           
    █   █   █   █            █   █   █       █   █   █                          
   █ █ █ █ █ █ █ █          █ █ █ █ █ █     █ █ █ █ █ █                         
  █               █        █           █   █           █                        
 █ █             █ █      █ █         █ █ █ █         █ █                       
    █           █   █    █   █       █       █       █   █                      
   █ █         █ █ █ █  █ █ █ █     █ █     █ █     █ █ █ █                     
  █   █       █       ██       █   █   █   █   █   █       █                    
 █ █ █ █     █ █     █  █     █ █ █ █ █ █ █ █ █ █ █ █     █ █                   
        █   █   █   █ ██ █   █                       █   █   █                  
       █ █ █ █ █ █ █      █ █ █                     █ █ █ █ █ █                 
      █             █    █     █                   █           █                
     █ █           █ █  █ █   █ █                 █ █         █ █               
    █   █         █   ██   █ █   █               █   █       █   █              
   █ █ █ █       █ █ █  █ █   █ █ █             █ █ █ █     █ █ █ █             
  █       █     █     ██   █ █     █           █       █   █       █            
 █ █     █ █   █ █   █  █ █   █   █ █         █ █     █ █ █ █     █ █           
    █   █   █ █   █ █ ██   █ █ █ █   █       █   █   █       █   █   █          
   █ █ █ █ █   █ █      █ █       █ █ █     █ █ █ █ █ █     █ █ █ █ █ █         
  █         █ █   █    █   █     █     █   █           █   █           █        
```
