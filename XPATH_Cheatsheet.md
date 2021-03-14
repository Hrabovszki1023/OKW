# XPATH cheat sheet for Selenium (but not only!) #

This is a collection of XPATH expressions that can be used as locators in OpenKeyWord or harmony.ac.
Other test automation tools must support the XPATH functions used.

## ID & Name ##
### Beliebiges Element mit id="myID" ####
Finden eines beliebiges Elements mit der id="myID"
> ```//*[@id="myID"]```

### <TAG>-Element mit id="myID" ####
Finden des <TAG>´s mit der id="myID"
> ```//TAG[@id="myID"]```
  
## Parent & Child ##
### Aria ###
#### Baum-Knotens mit dem Text ####
Finden eines Baum-Knotens, der genau den Text "myText" enthält, in der 2. Ebene<br>
> ```//**[@aria-level='2' and role='treeitem']//*[text()="myText"]/ancestor::*[@aria-level='2' and role='treeitem']```

#### Normalisierter Baum-Knotens mit dem Text ####
Finden eines normalisierten Baum-Knotens mit dem Text "myText" enthält, in der 2. Ebene.<br>
**Anmerkung:** Es werden all führenden und abschliessenden Whitespaces (Leerzeichen, Returns, Tabs) entfernt.<br>
> ```//**[@aria-level='2' and role='treeitem']//*[normalize-space(text(), "myText") ]/ancestor::*[@aria-level='2' and role='treeitem']```
