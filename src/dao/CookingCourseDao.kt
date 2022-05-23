package dao

import bean.CookingCourse

class CookingCourseDao (val list : MutableList<CookingCourse> = mutableListOf()) {
    fun add (c : CookingCourse) : Boolean {
        if (get(c.id) == null) {
            list.add(c)
            return true
        }
        return false
    }

    fun get (id: Int) : CookingCourse? {
        for (c in list) {
            if (c.id.equals(id))
                return c
        }
        return null
    }

    fun update (c : CookingCourse) : Boolean {
        for (i in 0 .. list.size-1) {
            if (list[i].id.equals(c.id)) {
                list[i] = c
                return true
            }
        }
        return false
    }

    fun delete (id : Int) : Boolean {
        for (i in 0 .. list.size-1) {
            if (list[i].id.equals(id)) {
                list.removeAt(i)
                return true
            }
        }
        return false
    }
}