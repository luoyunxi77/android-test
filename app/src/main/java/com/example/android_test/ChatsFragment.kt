package com.example.android_test

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_chats.*

class ChatsFragment : Fragment() {

    companion object {
        const val USER_NAME_KEY = "userName"
        const val USER_AGE_KEY = "userAge"
        fun newInstance(userName: String, userAge: Int): ChatsFragment {
            val bundle = Bundle()
            bundle.putString(USER_NAME_KEY, userName)
            bundle.putInt(USER_AGE_KEY, userAge)

            val chatFragment = ChatsFragment()
            chatFragment.arguments = bundle

            return chatFragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_chats, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val userNameMessage = it.get(USER_NAME_KEY).toString()
            val userAgeMessage = it.get(USER_AGE_KEY).toString()
            userName.text = userNameMessage
            userAge.text = userAgeMessage
        }

        viewUserDetail.setOnClickListener {
            val intent = Intent(activity, UserDetailActivity::class.java)
            startActivity(intent)
        }
    }
}