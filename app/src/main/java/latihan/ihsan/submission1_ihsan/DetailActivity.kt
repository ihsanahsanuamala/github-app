package latihan.ihsan.submission1_ihsan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object{
        const val USER = "user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
//
        val profileDetail = intent.getParcelableExtra<User>(USER)
//
//        tv_detail_name.text = profileDetail?.name
//        tv_detail_location.text = profileDetail?.location
//        tv_detail_repo.text = profileDetail?.repository
//        tv_detail_company.text = profileDetail?.company
//        tv_detail_followers.text = profileDetail?.followers
//        tv_detail_following.text =  profileDetail?.following

        profileDetail?.let{
            tv_detail_name.text = it.name
            tv_detail_location.text = it.location
            tv_detail_repo.text = it.repository
            tv_detail_company.text = it.company
            tv_detail_followers.text = it.followers
            tv_detail_following.text = it.following
        }

        Glide.with(this)
            .load(profileDetail?.profilePict)
            .into(iv_detail_profilePict)

        val actionBar = supportActionBar
        //        actionBar!!.title = profileDetail?.username
        actionBar?.apply {
            title = profileDetail?.username
            actionBar.setDisplayHomeAsUpEnabled(true)
        }
    

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return super.onOptionsItemSelected(item)
    }
}