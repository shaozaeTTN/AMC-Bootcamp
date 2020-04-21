# AMC Bootcamp Assignments
## Components Day 3
### Assignment


##### Questions

	
1. Explore all properties of resource merger .

2. Create component Important links. Author can add a title and a list of important links. Author can add as many links as he wants. If the link added by author is internal link, we need to add “HTML” extension to the link but if the link is external link(i.e. Outside of AEM) do not add the extension. Also For each link authoring, he gets the following fields: 1. Title  2. link 3. an dropdown to select whether the link should open in new tab or same tab.
Note: Read Resource resolver API and Resource API to cheeck if a link is AEM internal link or external.

 

3. Use list component of /libs/wcm/foundation/components/list , using extending and concept of resource merger. create  your own component and make following changes

    - Move tab Accessibility before settings tab

    - In settings tab , there is a property called “paginate after”, change the min property for this field from 0 to 2

    - Make this “paginate after” property to appear as second last property in settings tab

    - Remove “Description for  "Previous"” property from Accessibility tab

    - Add one new propery to setting tab to add title to list component


#### Note
* Custom components created(or extended) for the above are 'custom-list' and 'important-links'. Both of these belong to the componentGroup - 'customComponents' and are present under:
```ComponentDay2/ui.apps/src/main/content/jcr_root/apps/ComponentDay2/components/custom```

* Java logic handling URL for question2 is written inside URLHandler.java inside 
```core/models/```







