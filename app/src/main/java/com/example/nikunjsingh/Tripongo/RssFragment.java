package com.example.nikunjsingh.Tripongo;

/**
 * Created by NIKUNJ SINGH on 3/22/2016.
 */
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class RssFragment extends Fragment implements OnItemClickListener {

    private ProgressBar progressBar;
    private ListView listView;
    private View view;
    int city;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        Bundle broadcastData = getActivity().getIntent().getExtras();
        city = broadcastData.getInt("city");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_layout, container, false);
            progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
            listView = (ListView) view.findViewById(R.id.listView);
            listView.setOnItemClickListener(this);
            startService();
        } else {
            // If we are returning from a configuration change:
            // "view" is still attached to the previous view hierarchy
            // so we need to remove it and re-attach it to the current one
            ViewGroup parent = (ViewGroup) view.getParent();
            parent.removeView(view);
        }
        return view;
    }

    private void startService() {
        if(city==0)
        {
            Intent intent = new Intent(getActivity(), RssService.class);
            intent.putExtra(RssService.RECEIVER, resultReceiver);
            getActivity().startService(intent);
        }
        else if(city==2)
        {
            Intent intent = new Intent(getActivity(), RssService2.class);
            intent.putExtra(RssService2.RECEIVER, resultReceiver);
            getActivity().startService(intent);
        }
        else
        {
            Intent intent = new Intent(getActivity(), RssService1.class);
            intent.putExtra(RssService1.RECEIVER, resultReceiver);
            getActivity().startService(intent);
        }

    }

    /**
     * Once the {@link RssService} finishes its task, the result is sent to this
     * ResultReceiver.
     */
    private final ResultReceiver resultReceiver = new ResultReceiver(new Handler()) {
        @SuppressWarnings("unchecked")
        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            progressBar.setVisibility(View.GONE);
            if(city==0)
            {
                List<RssItem> items = (List<RssItem>) resultData.getSerializable(RssService.ITEMS);
                if (items != null) {
                    RssAdapter adapter = new RssAdapter(getActivity(), items);
                    listView.setAdapter(adapter);
                } else {
                    Toast.makeText(getActivity(), "An error occured while downloading the rss feed.",
                            Toast.LENGTH_LONG).show();
                }
            }
            else if(city==2)
            {
                List<RssItem> items = (List<RssItem>) resultData.getSerializable(RssService2.ITEMS);
                if (items != null) {
                    RssAdapter adapter = new RssAdapter(getActivity(), items);
                    listView.setAdapter(adapter);
                } else {
                    Toast.makeText(getActivity(), "An error occured while downloading the rss feed.",
                            Toast.LENGTH_LONG).show();
                }
            }
            else
            {
                List<RssItem> items = (List<RssItem>) resultData.getSerializable(RssService1.ITEMS);
                if (items != null) {
                    RssAdapter adapter = new RssAdapter(getActivity(), items);
                    listView.setAdapter(adapter);
                } else {
                    Toast.makeText(getActivity(), "An error occured while downloading the rss feed.",
                            Toast.LENGTH_LONG).show();
                }
            }
        }
    };

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        RssAdapter adapter = (RssAdapter) parent.getAdapter();
        RssItem item = (RssItem) adapter.getItem(position);
        Uri uri = Uri.parse(item.getLink());
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
