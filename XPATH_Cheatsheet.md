# XPATh cheat sheet for Selenium (but not only!) #

Das ist eine Samlung von XPATH Ausdrücken die als Locatoren in OpenKeyWord

## ID & Name ##

```//*[@id="myID"]```            Beliebiges Element mit der id="myID"
```//TAG[@id="myID"]```          Element <TAG> mit der id I (css: E#I)
  
## Parent & Child ##
### Aria ###
Finden eines Baum-Knotens, der den Text "myText" enthält, in der 2. Ebene<br>
> ``` //**[ @aria-level='2' and role='treeitem' ]/*[text()="myText"]/ancestor::*[@aria-level='2' and role='treeitem' ]```

#### normalisierten Baum-Knotens mit dem Text ####
Finden eines normalisierten Baum-Knotens mit dem Text "myText" enthält, in der 2. Ebene.<br>
**Anmerkung:** Es werden all führenden und abschliessenden Whitespaces (Leerzeichen, Returns, Tabs) entfernt.<br>
> ``` //**[ @aria-level='2' and role='treeitem' ]/*[normelize( text(), "myText") ]/ancestor::*[ @aria-level='2' and role='treeitem' ]```
