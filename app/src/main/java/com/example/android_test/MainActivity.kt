package com.example.android_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragment()
    }

    private fun loadFragment() {
        val bannerFragment = BannerFragment()
        supportFragmentManager.beginTransaction().add(R.id.banner_container, bannerFragment)
            .commit()
        val chatsFragment = ChatsFragment.newInstance("Lisa", 18)
        val contactsFragment = ContactsFragment()
        val discoverFragment = DiscoverFragment()
        val meFragment = MeFragment()
        val replaceFragment = ReplaceFragment()

        chats.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            clearFragment(transaction,bannerFragment)

            if (!chatsFragment.isAdded) {
                transaction
                    .add(R.id.fragment_container, chatsFragment)
            }
            transaction.show(chatsFragment)
            transaction.commit()
        }

        contacts.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            clearFragment(transaction,bannerFragment)

            if (!contactsFragment.isAdded) {
                transaction
                    .add(R.id.fragment_container, contactsFragment)
            }
            transaction.show(contactsFragment)
            transaction.commit()
        }

        discover.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            clearFragment(transaction,bannerFragment)

            if (!discoverFragment.isAdded) {
                transaction
                    .add(R.id.fragment_container, discoverFragment)
            }
            transaction.show(discoverFragment)
            transaction.commit()
        }

        me.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            clearFragment(transaction,bannerFragment)

            if (!meFragment.isAdded) {
                transaction
                    .add(R.id.fragment_container, meFragment)
            }
            transaction.show(meFragment)
            transaction.commit()
        }

        remove.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .remove(chatsFragment)
                .remove(contactsFragment)
                .remove(discoverFragment)
                .remove(meFragment)
                .remove(replaceFragment)
                .commit()
        }

        replace.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            clearFragment(transaction,bannerFragment)

            if (!replaceFragment.isAdded) {
                transaction
                    .replace(R.id.fragment_container, replaceFragment)
            }
            transaction.show(replaceFragment)
            transaction.commit()
        }
    }

    private fun clearFragment(transaction: FragmentTransaction, specialFragment: Fragment) {
        if (supportFragmentManager.fragments.size > 0) {
            supportFragmentManager.fragments.filter { it != specialFragment }
                .forEach { transaction.remove(it) }
        }
    }
}
