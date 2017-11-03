package com.dzimbainvestmenttrustgmail.dzimba.MainUserInterface;

/**
 * Created by gwari on 10/7/2017.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.dzimbainvestmenttrustgmail.dzimba.R;
import com.dzimbainvestmenttrustgmail.dzimba.fragmenttabs.ViewHomesTab;
import com.dzimbainvestmenttrustgmail.dzimba.paymentcode.BookingPayments;

import java.util.List;

/**
 * Render the RecyclerView, create an adapter class which inflates
 * the house_card_view by keeping appropriate information.
 * Create a class named HouseAdapter below
 */
public class HouseAdapter extends RecyclerView.Adapter<HouseAdapter.MyViewHolder> {


    //private member variables
    private Context mContext;
    private List<Houses> mHousesList;


//Create new subclass for MyViewHolder which extends Recycler


    public class MyViewHolder extends RecyclerView.ViewHolder {


        //public member variables
        public TextView title, location, count;
        public ImageView thumbnail, overflow;
        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.houseTitle);
            location = (TextView) itemView.findViewById(R.id.city_location);
            count = (TextView) itemView.findViewById(R.id.bedCount);
            thumbnail = (ImageView) itemView.findViewById(R.id.dzimba_thumbnail);
            overflow = (ImageView) itemView.findViewById(R.id.overflow);
        }
    }
    public HouseAdapter(Context mContext, List<Houses> mHouseList) {
        this.mContext = mContext;
        this.mHousesList =mHouseList;
    }


    //Instantiates the item layout file and view holder
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.house_card_view, parent, false);
        return new MyViewHolder(itemView);
    }


    //Loads the data (images & texts) at the specified position on the cardviews
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Houses houses = mHousesList.get(position);
        holder.title.setText(houses.getHouseName());
        holder.location.setText(houses.getCity());
        holder.count.setText(houses.getNumOfBeds() + " beds");


//use the glide library to load the house images
        Glide.with(mContext).load(houses.getThumbnail()).into(holder.thumbnail);
        holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(holder.overflow);
            }
        });
    }
    /**
     * Showing popup menu when tapping on 3 dots
     * @param view
     */
    private void showPopupMenu(View view) {
        //inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.bookings_menu, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyHomeMenuItemClickListener());
        popup.show();
    }

    //the listener class for the popup menu
    class MyHomeMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()){
                case R.id.bookings_page: Intent bookingsPageIntent = new Intent(mContext, BookingPayments.class);
                    mContext.startActivity(bookingsPageIntent);
                    return true;
                case R.id.view_homes_menu: Intent viewHomesIntent = new Intent(mContext, ViewHomesTab.class);
                    mContext.startActivity(viewHomesIntent);
                    Toast.makeText(mContext, "Welcome to Dzimba", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }



    @Override
    public int getItemCount() {
        return mHousesList.size();
    }
}
