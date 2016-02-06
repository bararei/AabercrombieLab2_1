package com.example.android.AabercrombieLab2_1;

import android.content.Context;

import java.util.ArrayList;
/**
 * Created by Spheven on 2/5/2016.
 */
public class IpsumSingleton {

    private static IpsumSingleton sIpsumSingleton;

    private Context mAppContext;

    private ArrayList<Ipsum> ipsumArrayList;

    private IpsumSingleton(Context appContext) {
        mAppContext = appContext;

        //populate with headlines and article information
        Ipsum ipsum1 = new Ipsum();
        ipsum1.setmHeadline("Article One");
        ipsum1.setmArticle("Article One\n\nExcepteur pour-over occaecat squid biodiesel umami gastropub, nulla laborum salvia dreamcatcher fanny pack. Ullamco culpa retro ea, trust fund excepteur eiusmod direct trade banksy nisi lo-fi cray messenger bag. Nesciunt esse carles selvage put a bird on it gluten-free, wes anderson ut trust fund twee occupy viral. Laboris small batch scenester pork belly, leggings ut farm-to-table aliquip yr nostrud iphone viral next level. Craft beer dreamcatcher pinterest truffaut ethnic, authentic brunch. Esse single-origin coffee banksy do next level tempor. Velit synth dreamcatcher, magna shoreditch in american apparel messenger bag narwhal PBR ennui farm-to-table.");
        ipsumArrayList.add(ipsum1);

        Ipsum ipsum2 = new Ipsum();
        ipsum2.setmHeadline("Article Two");
        ipsum2.setmArticle("Article Two\n\nVinyl williamsburg non velit, master cleanse four loko banh mi. Enim kogi keytar trust fund pop-up portland gentrify. Non ea typewriter dolore deserunt Austin. Ad magna ethical kogi mixtape next level. Aliqua pork belly thundercats, ut pop-up tattooed dreamcatcher kogi accusamus photo booth irony portland. Semiotics brunch ut locavore irure, enim etsy laborum stumptown carles gentrify post-ironic cray. Butcher 3 wolf moon blog synth, vegan carles odd future.");
        ipsumArrayList.add(ipsum2);
    }

    public static IpsumSingleton get(Context context) {
        if (sIpsumSingleton == null) {
            //create the singleton using the global context
            sIpsumSingleton = new IpsumSingleton(context.getApplicationContext());
        }
        return sIpsumSingleton;
    }

    public ArrayList<Ipsum> getIpsumArrayList() {
        return ipsumArrayList;
    }

}
