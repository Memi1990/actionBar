package com.example.actionbar

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionBar = supportActionBar
        actionBar!!.title = "Bed Time"
        actionBar.subtitle = "Configure your best rest"
        actionBar.setIcon(R.mipmap.ic_hmoon)
//        getActionBar()?.setIcon


        actionBar.setDisplayUseLogoEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)

        val vista = findViewById(R.id.tvHello) as TextView
        registerForContextMenu(vista)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        if (v?.id == R.id.tvHello){
            menuInflater.inflate(R.menu.contextual_menu, menu)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.home -> Toast.makeText(this, "Go Home", Toast.LENGTH_SHORT).show()
            R.id.settings -> {val i = Intent (this, SettingsActivity :: class.java)
                startActivity(i)}
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        super.onContextItemSelected(item)
        when (item.itemId){
            R.id.it1 -> Toast.makeText(this, "This is the first item", Toast.LENGTH_SHORT).show()
            R.id.it2 -> Toast.makeText(this, "This is the second item", Toast.LENGTH_SHORT).show()
            R.id.it3 -> Toast.makeText(this, "This is the third item", Toast.LENGTH_SHORT).show()
        }
        return super.onContextItemSelected(item)
    }
}