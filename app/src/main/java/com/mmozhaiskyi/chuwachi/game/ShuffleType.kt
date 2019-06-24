package com.mmozhaiskyi.chuwachi.game

data class Member(val id: String)

data class Team(val members: Set<Member>)

data class ShuffleResult(
    val opponents: List<Pair<Team, Team>>,
    val losers: Set<Member>
)

enum class ShuffleType {

    OneVsOne {
        override val TEAM_MEMBERS_COUNT: Int = 1
    },
    TwoVsTwo {
        override val TEAM_MEMBERS_COUNT: Int = 2
    };

    protected abstract val TEAM_MEMBERS_COUNT: Int

    fun shuffle(members: Set<Member>): ShuffleResult {
        require(members.size >= TEAM_MEMBERS_COUNT * 2) { "Members count is less than required" }

        var shuffled = members.shuffled().toMutableList()
        val takeAndDrop = fun (count: Int): Set<Member> {
            val result = shuffled.take(count)
            shuffled = shuffled.drop(count).toMutableList()

            return result.toSet()
        }

        val opponents = mutableListOf<Pair<Team, Team>>()
        while (shuffled.size >= TEAM_MEMBERS_COUNT * 2) {
            val firstTeam = Team(takeAndDrop(TEAM_MEMBERS_COUNT))
            val secondTeam = Team(takeAndDrop(TEAM_MEMBERS_COUNT))

            opponents.add(firstTeam to secondTeam)
        }

        return ShuffleResult(
            opponents,
            shuffled.toSet()
        )
    }
}
