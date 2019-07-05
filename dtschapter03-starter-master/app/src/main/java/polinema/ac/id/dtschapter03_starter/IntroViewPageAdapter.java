package polinema.ac.id.dtschapter03_starter;

import android.content.Context;
import android.view.View;

import org.xml.sax.helpers.ParserAdapter;

public class IntroViewPageAdapter extends ParserAdapter {
    Context mContext;
    list<ScreenItemtem> mListScreen;

    public IntroViewPageAdapter(Context mContext, list<ScreenItem> mListScreen ){
        this.mContext = mContext;
        this.mListScreen = mListScreen;
    }

    public int getCount(){
        return mListScreen.size();
    }

    public boolean isViewFromObject(View view, Object o){
        return view == o;
    }


}
