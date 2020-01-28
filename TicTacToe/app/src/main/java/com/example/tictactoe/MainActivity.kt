package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View) {
        when(v.id){
            R.id.b1->updated(r=0,c=0,p=player)
            R.id.b2->updated(r=0,c=1,p=player)
            R.id.b3->updated(r=0,c=2,p=player)
            R.id.b4->updated(r=1,c=0,p=player)
            R.id.b5->updated(r=1,c=1,p=player)
            R.id.b6->updated(r=1,c=2,p=player)
            R.id.b7->updated(r=2,c=0,p=player)
            R.id.b8->updated(r=2,c=1,p=player)
            R.id.b9->updated(r=2,c=2,p=player)
        }
        count++
                player=!player

        if(t1.text=="A WIN" || t1.text=="B WIN")
            return
        if(player)
            updatedis("A TURN")
        else
            updatedis("B TURN")
        if(count==9)
            updatedis("GAME DREW")

    }

    private fun updatedis(s: String) {
t1.text=s
        if(s.contains("WIN"))
            dis()

    }

    private fun dis() {
        for(i in  0..2){
            for(j in 0..2)
                board[i][j].isEnabled=false
        }
    }

    private fun updated(r: Int, c: Int, p: Boolean) {
var s1=if(player) "X" else "0"
        var c1=if(player) 1 else 0
        board[r][c].text=s1
        board[r][c].isEnabled=false
        boardstatus[r][c]=c1
        check()
    }

    private fun check() {
        for(i in 0..2){
            if(boardstatus[0][i]==boardstatus[1][i] && boardstatus[0][i]==boardstatus[2][i]){
                if(boardstatus[0][i]==1){
                    updatedis("A WIN")
                    break
                }
           else if(boardstatus[0][i]==0){
                updatedis("B WIN")
                    break
            }}
        }
        for(i in 0..2){
            if(boardstatus[i][0]==boardstatus[i][1] && boardstatus[i][0]==boardstatus[i][2]){
                if(boardstatus[i][0]==1){
                    updatedis("A WIN")
                    break
                }
                else if(boardstatus[i][0]==0){
                    updatedis("B WIN")
                break}}
        }

        if(boardstatus[0][0]==boardstatus[1][1] && boardstatus[0][0]==boardstatus[2][2]){
            if(boardstatus[0][0]==1){
                updatedis("A WIN")

            }
            else if(boardstatus[0][0]==0){
                updatedis("B WIN")}}


        if(boardstatus[2][0]==boardstatus[1][1] && boardstatus[2][0]==boardstatus[0][2]){
            if(boardstatus[0][2]==1){
                updatedis("A WIN")

            }
            else if(boardstatus[0][2]==0){
                updatedis("B WIN")}}

    }

    var player=true
    var count=0
    var boardstatus=Array(3){IntArray(3)}
    lateinit var board:Array<Array<Button>>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        board= arrayOf(
            arrayOf(b1,b2,b3),
            arrayOf(b4,b5,b6),
            arrayOf(b7,b8,b9)
        )
        for(i in board){
            for(j in i){
                j.setOnClickListener(this)
            }
        }
        initializeboardstatus()
        b10.setOnClickListener(){
            player=true
            count=0
            t1.text="A TURN"
            initializeboardstatus()
        }
    }

    private fun initializeboardstatus() {
        for(i in 0..2){
            for(j in 0..2){
                boardstatus[i][j]=-1
                board[i][j].text=""
                board[i][j].isEnabled=true
            }
        }

    }
}
