# vsm
Implementation of console vending snack machine. This application allows to do CRUD operation.

## How to run  
Clone this app on your computer:   
```git clone```  
Open it in your IDE, import all dependencies and run it.  

## This app includes the next available commands:  
```addCategory "<category name>" <price> <amont>```  
```addItem "<category name> <amount>```  
```purchase <date yyyy-MM-dd>```  
```report "<category name>" <date yyyy-MM-dd | yyyy-MM>```  
```list```  
```clear```  
```help```  
```exit```  

##How to work then start project

Please start inputting your command:
	
#####If you need help enter "help";
#####To close app enter "exit".

```addCategory "Chocolate bar" 32.75 12```
	Chocolate bar 32.75 12

```addCategory "Donut" 29.5```
Donut 29.50 0

```addCategory "Cracker" 18 2```
Cracker 18.00 2

```purchase "Cracker" 2021-04-21```
Cracker 18.00

```addItem "Donut" 3```
Donut 29.50 3

```purchase "Chocolate bar" 2021-04-22```
Chocolate bar 32.75

```purchase "Cracker" 2021-04-24```
Cracker 18.00

```purchase "Donut" 2021-04-25```
Donut 29.50

```list```

Chocolate bar 32.75 11

Donut 29.50 2

Cracker 18.00 0

```clear```
Cracker 18.00

```purchase "Chocolate bar" 2021-04-28```
Chocolate bar 32.75

```addItem "Donut" 10```
Donut 29.50 12

```list```

Chocolate bar 32.75 10

Donut 29.50 12

```report 2019-04```
There is nothing to report!

```report 2021-04```

Chocolate bar 32.75 2

Donut 29.50 1

Total 131.00

```report 2021-04-25```

Donut 29.50 1

Total 29.50

