package latihan.ihsan.submission1_ihsan
import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: UserAdapter

    private lateinit var dataName: Array<String>
    private lateinit var dataUsername: Array<String>
    private lateinit var dataLocation: Array<String>
    private lateinit var dataRepository: Array<String>
    private lateinit var dataCompany: Array<String>
    private lateinit var dataFollowers: Array<String>
    private lateinit var dataFollowing: Array<String>
    private lateinit var dataProfilePict: TypedArray

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = UserAdapter(this)
        lv_github.adapter = adapter

        prepare()
        addItem()

        lv_github.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
                showSelected(position)

        supportActionBar?.setDisplayShowTitleEnabled(true)
        }
    }

    private fun prepare() {
        dataName = resources.getStringArray(R.array.username)
        dataUsername = resources.getStringArray(R.array.username)
        dataLocation = resources.getStringArray(R.array.location)
        dataRepository = resources.getStringArray(R.array.repository)
        dataCompany = resources.getStringArray(R.array.company)
        dataFollowers = resources.getStringArray(R.array.followers)
        dataFollowing = resources.getStringArray(R.array.following)
        dataProfilePict = resources.obtainTypedArray(R.array.avatar)
    }

    private fun addItem() {
        for (position in dataName.indices) {
            val user = User(
                name = dataName[position],
                username = dataUsername[position],
                location = dataLocation[position],
                repository = dataRepository[position],
                company = dataCompany[position],
                followers = dataFollowers[position],
                following = dataFollowing[position],
                profilePict = dataProfilePict.getResourceId(position, 0)
            )
            adapter.usernes.add(user)
        }
    }

    private fun showSelected(position : Int) {
        val intent = Intent(this@MainActivity, DetailActivity::class.java)
        intent.putExtra(DetailActivity.USER, adapter.usernes[position])
        startActivity(intent)
    }
}