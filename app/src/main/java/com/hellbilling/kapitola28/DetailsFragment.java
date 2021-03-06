/***
	Copyright (c) 2011 CommonsWare, LLC
	
	Licensed under the Apache License, Version 2.0 (the "License"); you may
	not use this file except in compliance with the License. You may obtain
	a copy of the License at
		http://www.apache.org/licenses/LICENSE-2.0
	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
*/

package com.hellbilling.kapitola28;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class DetailsFragment extends Fragment {
    // toto musi kazdy fragment obsahovat, definuje to layout
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
														Bundle savedInstanceState) {
        // Layout je WebView
		return(inflater.inflate(R.layout.details_fragment, container, false));
	}

    // dava url do WebView
	public void loadUrl(String url) {
        // getView nacita zobrazenie, najde v nom browser a ten zavola loadUrl
		((WebView)(getView().findViewById(R.id.browser))).loadUrl(url);
	}
}