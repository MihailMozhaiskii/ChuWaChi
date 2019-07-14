package com.mmozhaiskyi.chuwachi.data.model

class MemberContainer<T>(val member: T)

data class Team(val members: Set<MemberContainer<*>>)

data class ShuffleResult(
    val opponents: List<Pair<Team, Team>>,
    val losers: Set<MemberContainer<*>>
)

enum class ShuffleType(private val teamMembersCount: Int) {

    OneVsOne(1),
    TwoVsTwo(2);

    fun shuffle(members: Set<MemberContainer<*>>): ShuffleResult {
        require(members.size >= teamMembersCount * 2) { "Members count is less than required" }

        var shuffled = members.shuffled().toMutableList()
        val takeAndDrop = fun (count: Int): Set<MemberContainer<*>> {
            val result = shuffled.take(count)
            shuffled = shuffled.drop(count).toMutableList()

            return result.toSet()
        }

        val opponents = mutableListOf<Pair<Team, Team>>()
        while (shuffled.size >= teamMembersCount * 2) {
            val firstTeam = Team(takeAndDrop(teamMembersCount))
            val secondTeam = Team(takeAndDrop(teamMembersCount))

            opponents.add(firstTeam to secondTeam)
        }

        return ShuffleResult(
            opponents,
            shuffled.toSet()
        )
    }
}
