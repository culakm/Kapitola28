package com.hellbilling.kapitola28;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends FragmentActivity implements com.hellbilling.kapitola28.CountryListener {
    private boolean detailsInline=false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        com.hellbilling.kapitola28.CountriesFragment countries
                =(CountriesFragment)getSupportFragmentManager()
                .findFragmentById(R.id.countries);

        countries.setCountryListener(this);

        Fragment f=getSupportFragmentManager().findFragmentById(R.id.details);

        detailsInline=(f!=null &&
                (getResources().getConfiguration().orientation==
                        Configuration.ORIENTATION_LANDSCAPE));

        if (detailsInline) {
            countries.enablePersistentSelection();
        }
        else if (f!=null) {
            f.getView().setVisibility(View.GONE);
        }
    }

    @Override
    public void onCountrySelected(Country c) {
        String url=getString(c.url);

        if (detailsInline) {
            ((DetailsFragment)getSupportFragmentManager()
                    .findFragmentById(R.id.details))
                    .loadUrl(url);
        }
        else {
            Intent i=new Intent(this, DetailsActivity.class);

            i.putExtra(DetailsActivity.EXTRA_URL, url);
            startActivity(i);
        }
    }
}
