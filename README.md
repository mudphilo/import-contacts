# Import Contacts and Media
This library will get all contacts and media into List Array. This repo has 2 libraries
  - contacts
  - mediaLibray

# contacts
  - Import all contacts into List Array of ContactInfo
# mediaLibray
  - Import all media into List Array of MediaInfo

### usage
copy contacts and mediaLibray folders into your app.
In your build.grade of your app
```
implementation project(':contacts') // adds contact library
implementation project(':mediaLibrary') // adds mediaLibrary
```

in your code, in Activity class use the below code to get contact list, this code must be run after requesting runtime permission **Manifest.permission.READ_CONTACTS**
```java

import ke.co.allysuperapp.contacts.ContactInfo;
import ke.co.allysuperapp.contacts.Contacts;

...

// request Manifest.permission.READ_CONTACTS rentime permission or this code will through error

Contacts contactLib = new Contacts(getApplicationContext());
   try {
        List<ContactInfo> contacts = contactLib.getContacts();
        for (int x = 0; x < contacts.size(); x++ ){
            Log.d("GOT CONTACT "+x,contacts.get(x).toString());
        }
   }
   catch (Exception e){
        e.printStackTrace();
   }
```

in your code, in Activity class use the below code to get media list, this code must be run after requesting runtime permission **Manifest.permission.READ_EXTERNAL_STORAGE**
**NB** this code must be run on bacground thread since it may tae time when the user has a lot of media to scan through
```java

import ke.co.allysuperapp.media.MediaFileInfo;
import ke.co.allysuperapp.media.MediaLibrary;

....

// request Manifest.permission.READ_EXTERNAL_STORAGE rentime permission or this code will through error


final MediaLibrary mediaLibrary = new MediaLibrary(getApplicationContext());
new Thread(new Runnable() {
        @Override
        public void run() {
            // DO your work here
            // get the data
            try {
                List<MediaFileInfo> infos = mediaLibrary.getMedia();
                for (int x = 0; x < infos.size(); x++ ){
                    Log.d("GOT MEDIA "+x,infos.get(x).toString());
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }).start();
```