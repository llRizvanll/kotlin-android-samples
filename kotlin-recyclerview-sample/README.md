## Android Kotlin RecyclerView


### 0. Add library
```java
implementation "androidx.recyclerview:recyclerview:1.1.0"
implementation "androidx.recyclerview:recyclerview-selection:1.1.0-beta01"
```

### 1. Add RecyclerView
```java
var recyclerView: RecyclerView? = null
recyclerView = findViewById(R.id.list_view)
```

### 2. Create your model
```java
data class UserData(var name : String, var place : String)
```


### 3. Create sample item row layout
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="horizontal" android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:padding="10dp">

    <ImageView
        android:layout_height="80dp"
        android:layout_width="80dp"
        android:src="@drawable/ic_launcher_background"
        android:id="@+id/item_image"/>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        android:layout_margin="10dp">
        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="sample name"
            android:textSize="20dp"
            android:id="@+id/item_name"/>

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="sample place"
            android:layout_marginTop="10dp"
            android:textSize="16dp"
            android:id="@+id/item_place"/>
    </LinearLayout>


</LinearLayout>
```


### 4. Create adapter class
```java
class UserAdapter(private val userData : ArrayList<UserData>) : RecyclerView.Adapter<UserAdapter.ViewHolder>(){


    class ViewHolder(row : View) : RecyclerView.ViewHolder(row){
        var itemTextNameView : TextView? = row.findViewById(R.id.item_name)
        var itemTextPlaceView : TextView? = row.findViewById(R.id.item_place)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent?.context)
            .inflate(R.layout.list_item,parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return userData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var userItem : UserData = userData[position]
        holder.itemTextNameView?.text = userItem.name
        holder.itemTextPlaceView?.text = userItem.place
    }

}
```

### 5. Combine all together
```java
        recyclerView = findViewById(R.id.list_view)

        //add adapter
        var listAdapter = UserAdapter(generateData())
        val layourManager = LinearLayoutManager(applicationContext)
        recyclerView?.layoutManager = layourManager
        recyclerView?.itemAnimator = DefaultItemAnimator()

        recyclerView?.adapter = listAdapter
        listAdapter.notifyDataSetChanged()
        
        ....
        private fun generateData(): ArrayList<UserData> {
                var resultData = ArrayList<UserData>()
        
                for (i in 0..9){
                    val userItem  = UserData("Kotlin","India")
                    resultData.add(userItem)
                }
                return resultData
            }
```

## Contact
Drop me an email if you want discuss anything further. [Email](rizvangh@gmail.com)

## License
Licensed under the MIT license.
