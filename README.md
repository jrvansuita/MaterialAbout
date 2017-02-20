<!-- Library Logo -->
<img src="https://github.com/jrvansuita/MaterialAbout/blob/master/app/src/main/res/mipmap-xxxhdpi/ic_launcher.png?raw=true" align="left" hspace="1" vspace="1">

<!-- Buy me a cup of coffe -->
<a href='https://ko-fi.com/A406JCM' style='margin:13px;' target='_blank' align="right"><img align="right" height='36' src='https://az743702.vo.msecnd.net/cdn/kofi4.png?v=f' alt='Buy Me a Coffee at ko-fi.com' /></a>
<a href='https://play.google.com/store/apps/details?id=com.vansuita.materialabout.sample&pcampaignid=MKT-Other-global-all-co-prtnr-py-PartBadge-Mar2515-1' target='_blank' align="right"><img align="right" height='36' src='https://s20.postimg.org/muzx3w4jh/google_play_badge.png' alt='Get it on Google Play' /></a>
# Material About


This is an [**Android**](https://developer.android.com) project. You, as a mobile developer, can use this library to show a material about screen in your apps.
It was build to make your life easier when introducing you to your users, and also, to create a about screen pattern for material android apps. It's really simple and dynamic, check it out.

</br>
##### Note: If you're missing some feature please let me know. Or even better, create a pull request. Also, I'm needing some help to translate the strings.xml to other languages.
##### Supported Languages until now: 🇺🇸 🇧🇷 🇪🇸 🇮🇹
</br>

<!-- JitPack integration -->
[![](https://jitpack.io/v/jrvansuita/MaterialAbout.svg)](https://jitpack.io/#jrvansuita/MaterialAbout)<a href="https://github.com/jrvansuita/MaterialAbout/releases/latest">
  <img alt="Latest release" src="https://img.shields.io/github/release/jrvansuita/MaterialAbout.svg" />
</a><!-- Android Arsenal -->
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-MaterialAbout-green.svg?)](https://android-arsenal.com/details/1/4614) [![MaterialUp](https://img.shields.io/badge/MaterialUp-MaterialAbout-6ad0d9.svg?)](https://www.uplabs.com/posts/MaterialAbout)<!-- License -->
<a target="_blank" href="/LICENSE.txt"><img src="http://img.shields.io/:License-MIT-yellow.svg" alt="MIT License" /></a><!-- Minimun Android Api -->
<a target="_blank" href="https://developer.android.com/reference/android/os/Build.VERSION_CODES.html#GINGERBREAD"><img src="https://img.shields.io/badge/API-9%2B-blue.svg?style=flat" alt="API" /></a> [![Codacy Badge](https://api.codacy.com/project/badge/Grade/118bb89e3bed43e2b462201654224a60)](https://www.codacy.com/app/jrvansuita/MaterialAbout?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=jrvansuita/PickImage&amp;utm_campaign=Badge_Grade) <!-- Apptize.io -->[![Appetize.io](https://img.shields.io/badge/Apptize.io-Run%20Now-brightgreen.svg?)](https://appetize.io/embed/7j6x11afygur1cn94zbme5dp1w?device=nexus7&scale=50&autoplay=true&orientation=portrait&deviceColor=black) [![Demo](https://img.shields.io/badge/Demo-Download-blue.svg)](http://apk-dl.com/dl/com.vansuita.materialabout.sample) <!-- Hits Count -->[![ghit.me](https://ghit.me/badge.svg?repo=jrvansuita/MaterialAbout)](https://ghit.me/repo/jrvansuita/MaterialAbout)<!--Open Source --> [![Open Source Love](https://badges.frapsoft.com/os/v2/open-source.svg?v=103)](https://github.com/jrvansuita) [![Beerpay](https://beerpay.io/jrvansuita/MaterialAbout/badge.svg?style=flat)](https://beerpay.io/jrvansuita/MaterialAbout)

# Screenshots

<img src="images/screenshots/dark.png" height='auto' width='280'/><img src="images/screenshots/light.png" height='auto' width='280'/><img src="images/screenshots/custom.png" height='auto' width='280'/>

# Setup

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

        View view = AboutBuilder.with(this)
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
                .setVersionAsAppTitle()
                .addShareAction(R.string.app_name)
                .build();

        addContentView(view, layoutParams);
    }
 ```
   
    
# Sample app code.
 The library has a lot more customization and features than is able to show here. Please check the sample app and feel free to help with a pull request. You can take a look at the sample app [located on this project](/app/).

#

<a href="https://plus.google.com/+JuniorVansuita" target="_blank">
  <img src="https://s20.postimg.org/59xees8vt/google_plus.png" alt="Google+" witdh="44" height="44" hspace="10">
</a>
<a href="https://www.linkedin.com/in/arleu-cezar-vansuita-júnior-83769271" target="_blank">
  <img src="https://s20.postimg.org/vxoeax4ah/linkedin.png" alt="LinkedIn" witdh="44" height="44" hspace="10">
</a>
<a href="https://www.instagram.com/jnrvans/" target="_blank">
  <img src="https://s20.postimg.org/lyyuap5h5/instagram.png" alt="Instagram" witdh="44" height="44" hspace="10">
</a>
<a href="https://github.com/jrvansuita" target="_blank">
  <img src="https://s20.postimg.org/jf37glhx5/github.png" alt="Github" witdh="44" height="44" hspace="10">
</a>
<a href="https://play.google.com/store/apps/dev?id=8002078663318221363" target="_blank">
  <img src="https://s20.postimg.org/5iuz4plo9/android.png" alt="Google Play Store" witdh="44" height="44" hspace="10">
</a>
<a href="mailto:vansuita.jr@gmail.com" target="_blank" >
  <img src="https://s20.postimg.org/slli3vn5l/email.png" alt="E-mail" witdh="44" height="44" hspace="10">
</a>
