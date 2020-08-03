# Target Fragment Bug in ViewPager2

This sample app showcases a bug found in ViewPager2 when launching a dialog fragment with a target fragment. The target fragment inside the dialog it will be returned as null with DNKA on when using ViewPager2. This does not happen when using ViewPager.


### Steps to Replicate
1. Enable `Do Not Keep Activities` in the developer settings
2. Launch the app and tap the `ViewPager2` button
3. Tap the `Launch Dialog Fragment` button
4. Background the app and bring it to the foreground (the app restores correctly)
5. Background and foreground the app again
6. App will crash when trying to restore (because the target fragment is null)

You can view the same implementation using Viewpager (tap the `ViewPager` button) and the app does not crash when restoring the dialog


### App Flow

`MainActivity` starts `MainFragment`

`MainFragment` can launch `ViewPagerFragment` or `ViewPager2Fragment`

`DemoFragment` is the fragment displayed by both ViewPagers and launches `DemoDialogFragment`
