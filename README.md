<!-- Library Logo -->
<img src="app/src/main/res/mipmap-xxxhdpi/ic_launcher.png?raw=true" align="left" hspace="1" vspace="1">

<!-- Buy me a cup of coffe -->
<a href='https://ko-fi.com/A406JCM' style='margin:13px;' target='_blank' align="right"><img align="right" height='36' src='https://az743702.vo.msecnd.net/cdn/kofi4.png?v=f' alt='Buy Me a Coffee at ko-fi.com' /></a>
<a href='https://play.google.com/store/apps/details?id=com.vansuita.materialabout.sample&pcampaignid=MKT-Other-global-all-co-prtnr-py-PartBadge-Mar2515-1' target='_blank' align="right"><img align="right" height='45' src='https://play.google.com/intl/en_us/badges/static/images/badges/en_badge_web_generic.png' alt='Get it on Google Play' /></a>
# Material About


This is an [**Android**](https://developer.android.com) project. You, as a mobile developer, can use this library to show a material about screen in your apps.
It was built to make your life easier when introducing you to your users, and also, to create an about screen pattern for material android apps. It's really simple and dynamic, check it out.

</br>

##### Note: If you're missing some feature please let me know. Or even better, create a pull request. Also, I'm needing some help to translate the strings.xml to other languages.

##### Supported Languages: 🇺🇸 🇧🇷 🇪🇸 🇮🇹 🇷🇺 🇩🇪 :cn: :tr: 🇺🇦 🇫🇷 🇦🇪 🇰🇷

</br>

<!-- JitPack integration -->
[![JitPack](https://jitpack.io/v/jrvansuita/MaterialAbout.svg)](https://jitpack.io/#jrvansuita/MaterialAbout)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-MaterialAbout-green.svg?)](https://android-arsenal.com/details/1/4614) [![MaterialUp](https://img.shields.io/badge/MaterialUp-MaterialAbout-6ad0d9.svg?)](https://www.uplabs.com/posts/material-about) 

# Sample app
 This library has a lot more customization and features than is able to show here. Please check the sample app and feel free to help with a pull request. You can take a look at the sample app [located on this project](/app/).

<img src="images/screenshots/dark.jpg" height='auto' width='270'/><img src="images/screenshots/light.jpg" height='auto' width='270'/><img src="images/screenshots/custom.jpg" height='auto' width='270'/>

[![Appetize.io](https://img.shields.io/badge/Apptize.io-Run%20Now-brightgreen.svg?)](https://appetize.io/embed/3b4dpd5kv90mpa67mp5h8mugc0?device=nexus7&scale=50&autoplay=true&orientation=portrait&deviceColor=black) [![Demo](https://img.shields.io/badge/Demo-Download-blue.svg)](http://apk-dl.com/dl/com.vansuita.materialabout.sample) 
 [![Codacy Badge](https://api.codacy.com/project/badge/Grade/118bb89e3bed43e2b462201654224a60)](https://www.codacy.com/app/jrvansuita/MaterialAbout?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=jrvansuita/MaterialAbout&amp;utm_campaign=Badge_Grade) 
 <a target="_blank" href="https://developer.android.com/reference/android/os/Build.VERSION_CODES.html#GINGERBREAD"><img src="https://img.shields.io/badge/API-9%2B-blue.svg?style=flat" alt="API" /></a>


# Setup

This library requires `minSdkVersion` to be set to `14` or above, like the [Official Support Library](https://developer.android.com/topic/libraries/support-library/index.html#api-versions).

#### Step #1. Add the JitPack repository to your build file:

```gradle
allprojects {
    repositories {
	...
	maven { url "https://jitpack.io" }
    }
}
```

#### Step #2. Add the dependency ([See latest release](https://jitpack.io/#jrvansuita/MaterialAbout)).

```groovy
dependencies {
       compile 'com.github.jrvansuita:MaterialAbout:+'
}
```
# Implementation

Create a [AboutView](/library/src/main/java/com/vansuita/materialabout/views/AboutView.java) instance with [AboutBuilder](/library/src/main/java/com/vansuita/materialabout/builder/AboutBuilder.java).
```java
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    AboutView view = AboutBuilder.with(this)
                 .setPhoto(R.mipmap.profile_picture)
                 .setCover(R.mipmap.profile_cover)
                 .setName("Your Full Name")
                 .setSubTitle("Mobile Developer")
                 .setBrief("I'm warmed of mobile technologies. Ideas maker, curious and nature lover.")
                 .setAppIcon(R.mipmap.ic_launcher)
                 .setAppName(R.string.app_name)
                 .addGooglePlayStoreLink("8002078663318221363")
                 .addGitHubLink("user")
                 .addFacebookLink("user")
                 .addFiveStarsAction()
                 .setVersionNameAsAppSubTitle()
                 .addShareAction(R.string.app_name)
                 .setWrapScrollView(true)
                 .setLinksAnimated(true)
                 .setShowAsCard(true)
                 .build();

    addContentView(view, layoutParams);
}
```


# Additional

### Getting the list of actions or links from AboutBuilder.

```java
AboutBuilder aboutBuilder = AboutBuilder.with(this);

List<Item> actions = aboutBuilder.getActions();
List<Item> links = aboutBuilder.getActions();
```


#### Getting the view instance of any action or link from AboutView?

```java
AboutView view = AboutBuilder.with(this)
                 ...
                 .build();

View lastLinkView = view.findItem(builder.getLastLink());
View lastActionView = view.findItem(builder.getLastAction());
```

# Used libraries

* [com.android.support:appcompat-v7](https://developer.android.com/topic/libraries/support-library/packages.html#v7-appcompat)
* [com.android.support:cardview-v7](https://developer.android.com/topic/libraries/support-library/packages.html#v7-cardview)
* [com.github.jrvansuita:IconHandler](https://github.com/jrvansuita/IconHandler)

#

<a href="https://www.instagram.com/jnrvans/" target="_blank">
  <img src="https://camo.githubusercontent.com/c9dacf0f25a1489fdbc6c0d2b41cda58b77fa210a13a886d6f99e027adfbd358/68747470733a2f2f6564656e742e6769746875622e696f2f537570657254696e7949636f6e732f696d616765732f7376672f696e7374616772616d2e737667" alt="Instagram" witdh="44" height="44" hspace="10">
</a>
<a href="https://github.com/jrvansuita" target="_blank">
  <img src="https://camo.githubusercontent.com/b079fe922f00c4b86f1b724fbc2e8141c468794ce8adbc9b7456e5e1ad09c622/68747470733a2f2f6564656e742e6769746875622e696f2f537570657254696e7949636f6e732f696d616765732f7376672f6769746875622e737667" alt="Github" witdh="44" height="44" hspace="10">
</a>
<a href="https://play.google.com/store/apps/dev?id=8002078663318221363" target="_blank">
  <img src="https://camo.githubusercontent.com/8ce12185c778e13eed2073e7a6aba042ce5092d4d41744e7052e0fc16363c386/68747470733a2f2f6564656e742e6769746875622e696f2f537570657254696e7949636f6e732f696d616765732f7376672f676f6f676c655f706c61792e737667" alt="Google Play Store" witdh="44" height="44" hspace="10">
</a>
<a href="mailto:vansuita.jr@gmail.com" target="_blank" >
  <img src="https://camo.githubusercontent.com/4a3dd8d10a27c272fd04b2ce8ed1a130606f95ea6a76b5e19ce8b642faa18c27/68747470733a2f2f6564656e742e6769746875622e696f2f537570657254696e7949636f6e732f696d616765732f7376672f676d61696c2e737667" alt="E-mail" witdh="44" height="44" hspace="10">
</a>
