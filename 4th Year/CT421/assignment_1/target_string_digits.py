#!/usr/bin/env python

import common
import string
from numpy.random import randint, rand
from random import choices
from dataclasses import dataclass


@dataclass
class Config(common.Config):
    target = str

    def __init__(self):
        super().__init__()
        # Generate a random string of digits that is self.length in length
        self.target = ''.join(choices(string.digits, k=self.length))

    def main(self):
        population = []

        # Generate a population of random strings which have digits 0-9
        for i in range(0, self.population_size):
            population.append(''.join(choices(string.digits, k=self.length)))

        self.genetic_algorithm(population, self.fitness, self.make_mutation)
        self.plot('Digit Target String')

    def fitness(self, individual):
        current_score = 0
        for i in range(self.length):
            # run over all the bits in the int, for all bits that are the
            # same as the target, increment the score
            if individual[i] == self.target[i]:
                current_score += 1
        return current_score

    # different make_mutation function to support strings instead of binary registers
    # Go to common.py -> make_mutation for documentation
    def make_mutation(self, individual):
        if rand() < self.rate_of_mutation:
            index = randint(0, self.length)
            digit = int(individual[index])

            # equal chance of new digit meaning one less or one more
            if rand() <= 0.5:
                return individual[:index] + str((digit + 1) % 9) + individual[index + 1:]
            else:
                return individual[:index] + str((digit - 1) % 9) + individual[index + 1:]
        return individual

    # different crossover function to support strings instead of binary registers
    # Go to common.py -> crossover for documentation
    def crossover(self, p1, p2):
        # init the offspring
        c1 = p1
        c2 = p2
        # will only do a crossover 'rate_of_crossover' of the time
        if rand() < self.rate_of_crossover:
            c1 = self.make_offspring(p1, p2)
            c2 = self.make_offspring(p1, p2)
        return c1, c2

    # different make_offspring function to support strings instead of binary registers
    # Go to common.py -> make_offspring for documentation
    def make_offspring(self, p1, p2):
        n = randint(1, self.length - 1)
        # appending the front n characters of parent 1 to self.length-n characters of parent 2
        return p1[:n] + p2[n:]


if __name__ == '__main__':
    c = Config()
    c.main()
