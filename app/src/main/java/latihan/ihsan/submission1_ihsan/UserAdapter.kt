package latihan.ihsan.submission1_ihsan

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView


class UserAdapter (private val context: Context) : BaseAdapter() {
     var usernes : ArrayList<User> = arrayListOf()

    override fun getItem(position: Int): Any {
        return usernes[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    override fun getCount(): Int {
        return usernes.size
    }

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup): View {
        var itemView = view
        if (itemView == null) { 
            itemView = LayoutInflater.from(context).inflate(R.layout.item_user, viewGroup, false)
        }

        val viewHolder = ViewHolder(itemView as View)
        val user = getItem(position) as User
        val bind = user

        viewHolder.adapterName.text = bind.name
        viewHolder.adapterUsername.text = bind.username
        viewHolder.adapterImg.setImageResource(bind.profilePict)
        return itemView
    }

     inner class ViewHolder (view: View) {
         val adapterName: TextView = view.findViewById(R.id.tv_name)
         val adapterUsername: TextView = view.findViewById(R.id.tv_username)
         val adapterImg: ImageView = view.findViewById(R.id.iv_img)
    }
}