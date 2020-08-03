# viewpager2bug
This repo showcases a bug found in the ViewPager2 implementation when launching a dialog fragment with a target fragment set. The target fragment inside the dialog it will be returned as null with DNKA on when using ViewPager2. When using ViewPager this does not occur. 
