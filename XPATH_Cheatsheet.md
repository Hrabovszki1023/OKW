# XPATH cheat sheet for Selenium (but not only!) #

This is a collection of XPATH expressions that can be used as locators in OpenKeyWord or harmony.ac.
Other test automation tools must support the XPATH functions used.

## ID & Name ##
### Beliebiges Element mit id="myID" ####
Find any element with the id="myID".
> ```//*[@id="myID"]```

### <TAG>-Element mit id="myID" ####
Find the <TAG>'s with the id="myID".
> ```//TAG[@id="myID"]```
  
## Parent & Child ##
### Aria ###
#### Baum-Knotens mit dem Text ####
Finding a tree node that contains exactly the text "myText" in the 2nd level<br>
> ```//**[@aria-level='2' and role='treeitem']//*[text()="myText"]/ancestor::*[@aria-level='2' and role='treeitem']```

#### Normalisierter Baum-Knotens mit dem Text ####
Finding a normalized tree node containing the text "myText", in the 2nd level.<br>
**Note:** All leading and trailing whitespaces (spaces, returns, tabs) are removed.<br>
> ```//**[@aria-level='2' and role='treeitem']//*[normalize-space(text(), "myText") ]/ancestor::*[@aria-level='2' and role='treeitem']```
