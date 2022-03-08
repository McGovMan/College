import matplotlib.pyplot as plt
from numpy.random import randint, rand
from dataclasses import dataclass
import statistics

# This file contains functions that are common to most, if not all
# python executables, such as: tournament_selection, crossover,
# make_offspring, make_mutation, plot & genetic_algorithm.
# If the executable has their own function they need to use,
# they just overwrite the method.
# Each executable also uses the base config below with defaults
# and adds in any extra variables they need on top of it.


@dataclass
class Config:
    fitness_averages: list[float]
    population_size: int
    length: int
    rate_of_mutation: float
    rate_of_crossover: float
    num_of_iterations: int

    def __init__(self):
        self.fitness_averages = []
        self.population_size = 100
        self.length = 30
        self.rate_of_mutation = 0.5
        self.rate_of_crossover = 0.8
        self.num_of_iterations = 15

    # Tournament selection is a method of selecting an individual from
    # a population of individuals. Tournament selection involves running
    # several tournaments among a few individuals chosen at random from
    # the population. The winner of each tournament (the one with the
    # best fitness) is selected for crossover.
    def tournament_selection(self, population, scores, rounds=5):
        # Kick off the process with a random person
        best_individual = randint(0, self.population_size)
        # Pick another random person and see if they are better than
        # the first random person
        for individual in randint(0, self.population_size, rounds - 1):
            if scores[individual] > scores[best_individual]:
                best_individual = individual
        # After all the rounds, return the most fit person in the population
        return population[best_individual]

    # Crossover is a genetic operator used to combine the genetic information
    # of two parents to generate new offspring. It is one way to stochastically
    # generate new solutions from an existing population.
    def crossover(self, p1, p2):
        # init the offspring
        c1 = p1
        c2 = p2
        # will only do a crossover 'rate_of_crossover' of the time
        if rand() < self.rate_of_crossover:
            c1 = self.make_offspring(p1, p2)
            c2 = self.make_offspring(p1, p2)
        return c1, c2

    # Explanation of the function below: https://www.geeksforgeeks.org/genetic-algorithm/
    # Basically, we're taking the front n bits from parent 1, and self.length - n bits from
    # parent 2 and putting them together to try and generate a new child that has the
    # attributes of their parents
    def make_offspring(self, p1, p2):
        n = randint(1, self.length - 1)
        s1 = ((1 << n) - 1) << (self.length - n)
        s2 = (1 << (self.length - n)) - 1
        # appending the front n bits of parent 1 to self.length-n bits of parent 2
        return (p1 & s1) | (p2 & s2)

    # We want the individual to have slightly different
    # attributes to their parents, so we change one of the bits
    # They aren't guaranteed to have a mutation though
    def make_mutation(self, individual):
        if rand() < self.rate_of_mutation:
            return individual ^ (1 << randint(0, self.length))
        return individual

    def genetic_algorithm(self, population, fitness_func, make_mutation_func):
        # run num_of_iterations generations
        for generation in range(self.num_of_iterations):
            # calculate the fitness's for each individual
            scores = [fitness_func(x) for x in population]
            self.fitness_averages.append(statistics.fmean(scores))

            parents = []
            children = []

            # best individuals in the population chosen for crossover
            for i in range(self.population_size):
                parents.append(self.tournament_selection(population, scores))

            # do the crossover
            for i in range(0, self.population_size, 2):
                for child in self.crossover(parents[i], parents[i + 1]):
                    child = make_mutation_func(child)
                    children.append(child)

            population = children

    # Plot the fitness measurements we collected
    def plot(self, test_name):
        plt.plot(range(1, self.num_of_iterations + 1), self.fitness_averages)
        plt.ylabel('Average fitness')
        plt.xlabel('Generation')
        plt.title(f'{test_name}: Average fitness with {self.num_of_iterations} generations')
        plt.grid(True)
        plt.show()
        print("Showing Plot...")
